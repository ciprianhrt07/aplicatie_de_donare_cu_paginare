import Calendar from "react-calendar";
import "react-calendar/dist/Calendar.css";
import { useNavigate, useParams } from "react-router-dom";
import DonatorService from "../service/DonatorService";
import ProgramariService from "../service/ProgramariService";

import { useState } from "react";

function Locatii({ locatie, donator ,setLocatie ,programari , setProgramari}) {
  //const [date, setDate] = useState(new Date());
  const navigate = useNavigate();

  const [programare, setProgramare] = useState({
    donatorId: donator.id,
    locatieId: locatie.id,
    date: new Date()
  });

  const handleDateChange = (date) => {
   
    const utcDate = new Date(
      Date.UTC(date.getFullYear(), date.getMonth(), date.getDate())
    );
 
    setProgramare({
      ...programare,
      date:  utcDate.toISOString().slice(0, 10)
    });
  };

  
  const saveProgramare = (e) => {
    e.preventDefault();
    DonatorService.saveProgramare(programare)
      .then((response) => {
 
        console.log(response);
        ProgramariService.getAllPD(donator).then((response) => {
          setProgramari(response.data);
        })
      })
      .catch((error) => {
        console.log(error);
      });
  };
  
  return (
    <tr>
      <td> {locatie.nume}</td>
      <td> {locatie.judet}</td>
      <td> {locatie.strada}</td>
      <td> {locatie.orar}</td>
      <td> {locatie.numarMaximProgramari}</td>
      <td> {locatie.numarProgramari}</td>

      <div>
        <div className="calendar-container">
          <Calendar onChange={handleDateChange} value={programare.date}  >

          </Calendar>

          
        </div>
      </div>

      <td> <button onClick={saveProgramare}> PROGRAMARE </button></td>
    </tr>
  );
}

export default Locatii;
