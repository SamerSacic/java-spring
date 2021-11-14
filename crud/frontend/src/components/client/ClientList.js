import { useState, useEffect } from "react";
import { Button, ButtonGroup, Container, Table } from "reactstrap";
import { Link } from "react-router-dom";
import axios from "axios";

import AppNavBar from "../ui/AppNavbar";

const ClientList = () => {
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

  const remove = (id) => {
    axios
      .delete(`/clients/${id}`)
      .then(() => {
        let updatedClients = [...clients].filter((client) => client.id !== id);
        setClients(updatedClients);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const clientList = clients.map((client) => {
    return (
      <tr key={client.id}>
        <td>{client.email}</td>
        <td>
          <ButtonGroup>
            <Button
              size="sm"
              color="primary"
              tag={Link}
              to={"/clients/" + client.id}
            >
              Edit
            </Button>
            <Button size="sm" color="danger" onClick={() => remove(client.id)}>
              Delete
            </Button>
          </ButtonGroup>
        </td>
      </tr>
    );
  });

  return (
    <div>
      <AppNavBar />
      <Container className="mt-3">
        <div className="d-flex align-items-center justify-content-between">
          <div>
            <h3>Clients</h3>
          </div>
          <div>
            <Button color="success" tag={Link} to="/clients/new">
              Add Client
            </Button>
          </div>
        </div>
        <Table className="mt-4">
          <thead>
            <tr>
              <th width="30%">Name</th>
              <th width="30%">Email</th>
              <th width="40%">Actions</th>
            </tr>
          </thead>
          <tbody>{clientList ? clientList : "No Client available!!!"}</tbody>
        </Table>
      </Container>
    </div>
  );
};

export default ClientList;
