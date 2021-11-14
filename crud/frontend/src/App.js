import { useState, useEffect } from "react";
import axios from "axios";

const App = () => {
  const [clients, setClients] = useState([]);

  useEffect(() => {
    axios
      .get("/clients")
      .then((response) => {
        const { data } = response;
        setClients(data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  return (
    <div className="container">
      <h2>Clients</h2>
      {clients?.map((client) => (
        <div key={client.id}>
          {client.name} {client.email}
        </div>
      ))}
    </div>
  );
};

export default App;
