import React, { useState } from 'react';
import Button from 'react-bootstrap/esm/Button';
import Form from 'react-bootstrap/Form';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

const Vehicle = () => {
    const userId = localStorage.getItem('userId')
  const [vehicleDetails, setVehicleDetails] = useState({
    type: '',
    company: '',
    regdate: '',
    userId: userId
  });

  const navigate = useNavigate();

  const handleInputChange = (event) => {
    const { id, value } = event.target;
    setVehicleDetails((prevDetails) => ({
      ...prevDetails,
      [id]: value,
    }));
  };

  const handleVehicleTypeChange = (event) => {
    setVehicleDetails((prevDetails) => ({
      ...prevDetails,
      type: event.target.value,
    }));
  };

  const handleSubmit = (event) => {
    event.preventDefault();

    // Send vehicle details to the backend using Axios
    axios
      .post('http://localhost:8080/vehicle/add', vehicleDetails) // Replace with your actual API endpoint
      .then((response) => {
        console.log('Vehicle details added successfully', response.data);
        // Perform further actions, such as redirecting the user or showing a success message.
        navigate('/policy');
        localStorage.setItem('vehicleId', response.data.id);
      })
      .catch((error) => {
        console.error('Error adding vehicle details', error);
        // Handle errors, such as displaying an error message to the user.
      });
  };

  return (
    <div>
      <Form onSubmit={handleSubmit}>
        <h4>Add vehicle details</h4>
        <Form.Group className="mb-3" controlId="type">
          <Form.Label>Vehicle Type</Form.Label>
          <div>
            <Form.Check
              type="radio"
              label="Two Wheeler"
              value="TWOWHEELER"
              checked={vehicleDetails.type === 'TWOWHEELER'}
              onChange={handleVehicleTypeChange}
            />
            <Form.Check
              type="radio"
              label="Four Wheeler"
              value="FOURWHEELER"
              checked={vehicleDetails.type === 'FOURWHEELER'}
              onChange={handleVehicleTypeChange}
            />
          </div>
        </Form.Group>

        <Form.Group className="mb-3" controlId="company">
          <Form.Label>Company</Form.Label>
          <Form.Control
            type="text"
            placeholder="Vehicle Company"
            value={vehicleDetails.company}
            onChange={handleInputChange}
          />
        </Form.Group>
        <Form.Group className="mb-3" controlId="regdate">
          <Form.Label>Registration Date</Form.Label>
          <Form.Control
            type="date"
            placeholder="Vehicle Registration Date"
            value={vehicleDetails.regdate}
            onChange={handleInputChange}
          />
        </Form.Group>
        <Button variant="primary" type="submit">
          Submit
        </Button>
      </Form>
    </div>
  );
};

export default Vehicle;
