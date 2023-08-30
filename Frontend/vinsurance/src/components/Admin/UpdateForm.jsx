import React from 'react'
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { useState } from 'react';
import axios from 'axios';

const UpdateForm = ({data}) => {
    
    const [credentials, setCredentials] = useState({
        id: data.id,
        firstName: data.firstName,
        lastName: data.lastName,
        mobileNo: data.mobileNo,
        address: data.address,
        dob: data.dob,
        email: data.email,
        password: data.password,
        role: data.role,
    });

    const handleChange = (e) => {
        const { id, value } = e.target;
        setCredentials((prevCredentials) => ({
            ...prevCredentials,
            [id]: value,
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        console.log(credentials);
        const url = `http://localhost:8080/user/${data.id}`;
        
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
    };

    return (
        <div>
            <Form onSubmit={handleSubmit}>
                <Form.Group controlId="firstName">
                    <Form.Label>First Name</Form.Label>
                    <Form.Control
                        type="text"
                        placeholder={data.firstName}
                    //    value={data.firstName}
                    onChange={handleChange}
                       
                    />
                </Form.Group>

                <Form.Group controlId="lastName">
                    <Form.Label>Last Name</Form.Label>
                    <Form.Control
                        type="text"
                        placeholder={data.lastName}
                        // value={data.lastName}
                    onChange={handleChange}

                    />
                </Form.Group>

                <Form.Group controlId="mobileNo">
                    <Form.Label>Mobile No</Form.Label>
                    <Form.Control
                        type="text"
                        placeholder={data.mobileNo}
                    // value={data.mobileNo}
                    onChange={handleChange}

                    />
                </Form.Group>

                <Form.Group controlId="address">
                    <Form.Label>Address</Form.Label>
                    <Form.Control
                        type="text"
                        placeholder={data.address}
                    // value={data.address}
                    onChange={handleChange}

                    />
                </Form.Group>

                <Form.Group controlId="dob">
                    <Form.Label>Date of Birth</Form.Label>
                    <Form.Control
                        type="date"
                        placeholder={data.date}
                    // value={data.dob}
                    onChange={handleChange}

                    />
                </Form.Group>

                <Form.Group controlId="email">
                    <Form.Label>Email</Form.Label>
                    <Form.Control
                        type="email"
                        placeholder={data.email}
                    // value={data.email}
                    onChange={handleChange}

                    />
                </Form.Group>




                <Button variant="primary" type="submit">
                    Update
                </Button>
            </Form>
        </div>
    )
}

export default UpdateForm
