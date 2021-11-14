import AppNavbar from "../ui/AppNavbar";
import { Link } from "react-router-dom";
import { Button, Container } from "reactstrap";

const Home = () => {
  return (
    <div>
      <AppNavbar />
      <Container>
        <Button color="link">
          <Link to="/clients">Clients</Link>
        </Button>
      </Container>
    </div>
  );
};

export default Home;
