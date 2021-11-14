// import { useState } from "react";
import { Navbar, NavbarBrand, Container } from "reactstrap";
import { Link } from "react-router-dom";

const AppNavbar = () => {
  // const [isOpen, setIsOpen] = useState(false);

  // const toggle = () => {
  //   setIsOpen({
  //     isOpen: !isOpen,
  //   });
  // };

  return (
    <Navbar color="dark" dark expand="md" className="px-3">
      <Container>
        <NavbarBrand tag={Link} to="/">
          Home
        </NavbarBrand>
      </Container>
    </Navbar>
  );
};

export default AppNavbar;
