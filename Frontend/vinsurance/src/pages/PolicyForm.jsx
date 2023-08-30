import React from 'react';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import { useState } from 'react';

const PolicyForm = (ptype) => {
    console.log(ptype.type);

    // Calculate validity date as 1 year from the current date
    const currentDate = new Date();
    const oneYearLater = new Date(currentDate);
    oneYearLater.setFullYear(oneYearLater.getFullYear() + 1);
    const userId = localStorage.getItem('userId');
    const vehicleId = localStorage.getItem('vehicleId');

    const calculateAmount = () => {
        if (ptype.type === 'TWO_WHEELER_FIRST_PARTY') {
            return 1000;
        } else if (ptype.type === 'TWO_WHEELER_THIRD_PARTY') {
            return 500;
        } else if (ptype.type === 'FOUR_WHEELER_FIRST_PARTY') {
            return 2000;
        } else if (ptype.type === 'FOUR_WHEELER_THIRD_PARTY') {
            return 1500;
        }
        return 0;
    };
    
    // Format the validity date as "YYYY-MM-DD" string
    const formattedValidityDate = `${oneYearLater.getFullYear()}-${(oneYearLater.getMonth() + 1).toString().padStart(2, '0')}-${oneYearLater.getDate().toString().padStart(2, '0')}`;
    const navigate = useNavigate();
    const amt = calculateAmount();
    console.log(amt)

    const [paymentMode, setPaymentMode] = useState("DEBIT CARD"); // Default value

    const handlePaymentModeChange = (e) => {
        setPaymentMode(e.target.value);
    };
    
    const handlePayment = () => {
        const pid = localStorage.getItem('policyId')
        // Prepare data for the POST request
        const paymentData = {
            policyId: pid,
            mode: paymentMode,
            amount: amt
        };

        // Send the payment data to the backend using Axios
        axios.post('http://localhost:8080/payment/add', paymentData) // Replace with your actual API endpoint
            .then((response) => {
                console.log('Payment successful', response.data);
                // Perform further actions, such as showing a success message.
                navigate('/booked')
            })
            .catch((error) => {
                console.error('Error making payment', error);
                // Handle errors, such as displaying an error message to the user.
            });

            
    };

    const handleSubmit = (event) => {
        event.preventDefault();

        // Prepare data for the POST request
        const formData = {
            userId: userId,
            vehicleId: vehicleId,
            policy: ptype.type,
            validity: formattedValidityDate,
            amount: amt,
            purchaseDate: new Date().toISOString().split('T')[0]
        };

        // Send the data to the backend using Axios
        axios.post('http://localhost:8080/policy/add', formData) // Replace with your actual API endpoint
            .then((response) => {
                console.log('Policy bought successfully', response.data);
                // Perform further actions, such as redirecting the user or showing a success message.
                localStorage.setItem('policyId',response.data.id)
            })
            .catch((error) => {
                console.error('Error buying policy', error);
                // Handle errors, such as displaying an error message to the user.
            });
            handlePayment();
            
    };
    return (
        <div>
            <Form onSubmit={handleSubmit}>
                <h4>Policies</h4>
                <Form.Group className="mb-3" controlId="policy-type">
                    <Form.Label>Policy Type</Form.Label>
                    <Form.Control type="text" placeholder={ptype.type} defaultValue={ptype.type} readOnly />
                </Form.Group>

                <Form.Group className="mb-3" controlId="validity">
                    <Form.Label>Validity</Form.Label>
                    <Form.Control type="date" placeholder="Vehicle Policy Validity" defaultValue={formattedValidityDate} readOnly />
                </Form.Group>

                <Form.Group className="mb-3" controlId="amount">
                    <Form.Label>Policy amount</Form.Label>
                    <Form.Control type="number" placeholder={calculateAmount()} defaultValue={calculateAmount()} readOnly />
                </Form.Group>

                 <Form.Group className="mb-3" controlId="payment-mode">
                    <Form.Label>Payment Mode</Form.Label>
                    <Form.Check
                        type="radio"
                        label="DEBIT CARD"
                        name="paymentMode"
                        value="DEBIT CARD"
                        checked={paymentMode === "DEBIT CARD"}
                        onChange={handlePaymentModeChange}
                    />
                    <Form.Check
                        type="radio"
                        label="UPI"
                        name="paymentMode"
                        value="UPI"
                        checked={paymentMode === "UPI"}
                        onChange={handlePaymentModeChange}
                    />
                    <Form.Check
                        type="radio"
                        label="CREDIT CARD"
                        name="paymentMode"
                        value="CREDIT CARD"
                        checked={paymentMode === "CREDIT CARD"}
                        onChange={handlePaymentModeChange}
                    />
                </Form.Group>

                <Button variant="primary" type="submit">
                    Buy Policy
                </Button>
            </Form>
        </div>
    );
};

export default PolicyForm;
