import React from 'react'
import Table from 'react-bootstrap/Table';
import axios from 'axios';
import { useState, useEffect } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import UpdateForm from './UpdateForm';


const Getuser = () => {

  const [users, setUsers] = useState([]);



  const [btn, setBtn] = useState("");


  const fetchUsers = async(e) => {
    const url = 'http://localhost:8080/user'; // Replace with your actual API endpoint

    try {
      const response = await axios.get(url);

      if (response.status === 200) {
        // console.log(response.data);
        setUsers(response.data);
      } else {
        throw new Error('Request failed');
      }
    } catch (error) {
      console.error('Error:', error);
    }
  }
  const [credentials, setCredentials] = useState({
    id: undefined,
    firstName: "",
    lastName: "",
    mobileNo: "",
    address: "",
    dob: "",
    email: "",
    password: "",
    role: "",

  });

  const handleClick = async (e) => {
    e.preventDefault();
    console.log(credentials);
    const url = "http://localhost:8080/User/update/";
    console.log(JSON.stringify(credentials))
    try {
      const response = await axios.put(url, credentials);

      if (response.status === 200) {
        alert('Updated successfully');
      } else {
        alert('Error');
      }
    } catch (error) {
      console.error('Error:', error);
    }
  }

  const handleButton = (id, firstName, lastName, mobileNo, address, dob, email, password, role) => {

    setCredentials({
      id: id,
      firstName: firstName,
      lastName: lastName,
      mobileNo: mobileNo,
      address: address,
      dob: dob,
      email: email,
      password: password,
      role: role,
    })
    console.log(credentials);



  };

  const deleteBookingById = async (id) => {
    const url = `http://localhost:8080/user/${id}`; // Replace with your actual API endpoint

    try {
      const response = await axios.delete(url);

      if (response.status === 200) {
        alert(`Booking with id  ${ id } is deleted`)
      } else {
        // Handle other response statuses
      }
    } catch (error) {
      // Handle error
    }
  };
  const handleDelete = (id) => {
    deleteBookingById(id);

  };



  return (
    <div className='container'>
      <div className='user-display'>
        <Button onClick={fetchUsers} >Fetch Users</Button>

        <h2>User List</h2>
        <Table striped bordered hover>
          <thead>
            <tr>
              <th>User Id</th>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Email</th>
              <th>DOB</th>
              <th>Address</th>
              <th>Mob no</th>
              <th>Role</th>
            </tr>
          </thead>
          <tbody>
            {users.map((user, index) => (

              <tr key={index}>

                <td>{user.id}</td>
                <td>{user.firstName}</td>
                <td>{user.lastName}</td>
                <td>{user.email}</td>
                <td>{user.dob}</td>
                <td>{user.address}</td>
                <td>{user.mobileNo}</td>
                <td>{user.role}</td>
                <td>


                  <Button value="update" onClick={() =>
                    handleButton(
                      user.id,
                      user.firstName,
                      user.lastName,
                      user.mobileNo,
                      user.address,
                      user.dob,
                      user.email,
                      user.password,
                      user.role
                    )
                  }>
                    Update
                  </Button>
                  <Button value="delete" onClick={() => handleDelete(user.id)}>Delete</Button>
                </td>

              </tr>
            ))}
          </tbody>
        </Table>
      </div>
      <div className='user-add'>

        <h3>Update user</h3>
        <UpdateForm data={credentials}/>

      </div>
    </div>
  )
  // return (
  //   <div>
  //     <Table >
  //     <thead>
  //       <tr>
  //         <th>User Id</th>
  //         <th>First Name</th>
  //         <th>Last Name</th>
  //         <th>Email</th>
  //         <th>DOB</th>
  //         <th>Address</th>
  //         <th>Mob no</th>
  //         <th>Role</th>
  //       </tr>
  //     </thead>
  //     <tbody>

  //     </tbody>

  //   </Table>
  //   </div>
  // )
}

export default Getuser


