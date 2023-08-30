import React, { useState } from 'react'
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { Link, useNavigate } from 'react-router-dom';
import axios
    from 'axios';
const Login = () => {

    const [credentials, setCredentials] = useState({
        email: '',
        password: ''
    });

    const navigate = useNavigate();

    const handleInputChange = (event) => {
        const { id, value } = event.target;
        setCredentials((prevCredentials) => ({
            ...prevCredentials,
            [id]: value,
        }));
    };

    const handleSubmit = (event) => {
        event.preventDefault();

        // Send form data to the backend using Axios
        axios.post('http://localhost:8080/api/users/login', credentials) // Replace with your actual API endpoint
            .then((response) => {
                localStorage.setItem('userId', response.data.id);
                localStorage.setItem('userName',response.data.firstName);
                localStorage.setItem('userRole',response.data.role);

                console.log('Login successful');
                // You can perform further actions here, such as redirecting the user or storing a token.
                if(localStorage.getItem('userRole') ==='ADMIN'){
                    navigate('/admin')
                }else{
                    navigate('/vehicle'); // Redirect to the desired page
                }
                    
            })
            .catch((error) => {
                console.error('Login failed', error);
                // You can handle errors here, such as displaying an error message to the user.
            });
    };
    

    return (
        <div>
            <Form onSubmit={handleSubmit}>
                <Form.Group className="mb-3" controlId="email">
                    <Form.Label>Email address</Form.Label>
                    <Form.Control type="email" placeholder="Enter email" onChange={handleInputChange}/>

                </Form.Group>

                <Form.Group className="mb-3" controlId="password">
                    <Form.Label>Password</Form.Label>
                    <Form.Control type="password" placeholder="Password" onChange={handleInputChange}/>
                </Form.Group>
                <Form.Group className="mb-3" controlId="formBasicPassword">
                    Don't have an account signup  <Link to= "/signup">here </Link>
                </Form.Group>
                <Button variant="primary" type="submit">
                    Submit
                </Button>
            </Form>
        </div>
    
    )
}

export default Login
