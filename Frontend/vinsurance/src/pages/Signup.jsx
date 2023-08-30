import React from 'react'
import Form from 'react-bootstrap/Form';
import axios from 'axios'
import { useState } from 'react';
import Button from 'react-bootstrap/esm/Button';
import { useNavigate } from 'react-router-dom';

const Signup = () => {
   const navigate = useNavigate();
  const [formData, setFormData] = useState({
    firstName: '',
    lastName: '',
    mobileNo: '',
    address: '',
    dob: '',
    email: '',
    password: '',
    role: 'CUSTOMER',
  });

  const handleInputChange = (event) => {
    const { id, value } = event.target;
    setFormData((prevData) => ({
      ...prevData,
      [id]: value,
    }));
  };

  const handleSubmit = (event) => {
    event.preventDefault();

    // Send form data to the backend using Axios
    axios.post('http://localhost:8080/user/', formData)
      .then((response) => {
        // console.log('Form data sent successfully', response.data);
        alert('user added successfully')
        navigate('/home')
        // You can perform further actions here, such as showing a success message to the user.
      })
      .catch((error) => {
        console.error('Error sending form data', error);
        // You can handle errors here, such as displaying an error message to the user.
      });
  };
  
  return (
    <div>
      <Form onSubmit={handleSubmit}>
        <h4>Registration</h4>
      <Form.Group className="mb-3" controlId="firstName">
        <Form.Label>First Name</Form.Label>
        <Form.Control type="text" placeholder="Enter First Name" onChange={handleInputChange}/>
      </Form.Group>
      <Form.Group className="mb-3" controlId="lastName">
        <Form.Label>Last Name</Form.Label>
        <Form.Control type="text" placeholder="Enter Last Name" onChange={handleInputChange}/>
      </Form.Group>

      <Form.Group className="mb-3" controlId="mobileNo">
        <Form.Label>Mobile </Form.Label>
        <Form.Control type="text" placeholder="Enter Mobile No" onChange={handleInputChange}/>
      </Form.Group>
      
      <Form.Group className="mb-3" controlId="address">
        <Form.Label>Address</Form.Label>
        <Form.Control type="text" placeholder="Enter address" onChange={handleInputChange}/>
      </Form.Group>
     
      <Form.Group className="mb-3" controlId="dob">
        <Form.Label>DOB</Form.Label>
        <Form.Control type="date" placeholder="Enter DOB" onChange={handleInputChange}/>
      </Form.Group>
       
      <Form.Group className="mb-3" controlId="email">
        <Form.Label>Email</Form.Label>
        <Form.Control type="eamil" placeholder="Enter Email" onChange={handleInputChange}/>
      </Form.Group>

      <Form.Group className="mb-3" controlId="password">
        <Form.Label>Password</Form.Label>
        <Form.Control type="password" placeholder="Password" onChange={handleInputChange}/>
      </Form.Group>

      {/* <Form.Group className="mb-3" controlId="role">
        <Form.Label>Role</Form.Label>
        <Form.Control type="text" placeholder="Role" onChange={handleInputChange}/>
      </Form.Group> */}
      <Button onClick={handleSubmit}>Submit</Button>
    </Form>
    </div>
  )
}

export default Signup
