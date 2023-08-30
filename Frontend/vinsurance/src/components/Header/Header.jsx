import React from 'react';
import Container from 'react-bootstrap/Container';
import Button from 'react-bootstrap/esm/Button';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import { Link, useNavigate } from 'react-router-dom';

const Header = () => {
  const navigate = useNavigate();
  const handleLogout = () => {
    // Clear userId from localStorage
    localStorage.removeItem('userId');
    localStorage.removeItem('userName');
    localStorage.removeItem('userRole');
    localStorage.removeItem('vehicleId');

    // Perform any other logout-related actions (e.g., redirecting to a login page)
    // ...

    console.log('Logged out');
    navigate('/home');

  };

  const userId = localStorage.getItem('userId');
  const userRole=localStorage.getItem('userRole');
  const userName = localStorage.getItem('userName');
  

  

  return (
    <div>
      <Navbar expand="lg" className="bg-body-tertiary">
        <Container>
          <Navbar.Brand>InsuranceBazaar</Navbar.Brand>
          <Navbar.Toggle aria-controls="basic-navbar-nav" />
          <Navbar.Collapse id="basic-navbar-nav">
            <Nav className="me-auto">
              <Nav.Link>
                <Link to="/">Home</Link>
              </Nav.Link>
              <Nav.Link>
                <Link to="/policy">Policy</Link>
              </Nav.Link>
              {userId? <div>{userName}<span>({userRole})</span> <Button onClick={handleLogout}>Logout</Button></div>
              : null}
            </Nav>
            {/* {userId ? (
              <Nav>
                <NavDropdown title={`${userName} (${userRole})`} id="basic-nav-dropdown">
                  <NavDropdown.Item onClick={handleLogout}>Logout</NavDropdown.Item>
                </NavDropdown>
              </Nav>
            ) : null} */}
          </Navbar.Collapse>
        </Container>
      </Navbar>
    </div>
  );
};

export default Header;
