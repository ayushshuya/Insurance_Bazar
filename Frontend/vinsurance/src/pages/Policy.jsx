import React, { useState } from 'react';
import PolicyForm from './PolicyForm';

const Policy = () => {
    const [selectedItem, setSelectedItem] = useState(null);

    const handleRadioSelect = (item) => {
        setSelectedItem(item);
    };

    const renderForm = () => {
        if (selectedItem === 'TWO_WHEELER_FIRST_PARTY') {
            return <div><PolicyForm type={selectedItem}/></div>;
        } else if (selectedItem === 'TWO_WHEELER_THIRD_PARTY') {
            return <div><PolicyForm type={selectedItem}/></div>;
        } else if (selectedItem === 'FOUR_WHEELER_FIRST_PARTY') {
            return <div><PolicyForm type={selectedItem}/></div>;
        } else if (selectedItem === 'FOUR_WHEELER_THIRD_PARTY') {
            return <div><PolicyForm type={selectedItem}/></div>;
        }

        return null;
    };

    return (
        <div>
            <div>
                <label>
                    <input
                        type="radio"
                        value="TWO_WHEELER_FIRST_PARTY"
                        checked={selectedItem === 'TWO_WHEELER_FIRST_PARTY'}
                        onChange={() => handleRadioSelect('TWO_WHEELER_FIRST_PARTY')}
                    />
                    Two Wheeler First Party
                </label>
            </div>
            <div>
                <label>
                    <input
                        type="radio"
                        value="TWO_WHEELER_THIRD_PARTY"
                        checked={selectedItem === 'TWO_WHEELER_THIRD_PARTY'}
                        onChange={() => handleRadioSelect('TWO_WHEELER_THIRD_PARTY')}
                    />
                    Two Wheeler Third Party
                </label>
            </div>
            <div>
                <label>
                    <input
                        type="radio"
                        value="FOUR_WHEELER_FIRST_PARTY"
                        checked={selectedItem === 'FOUR_WHEELER_FIRST_PARTY'}
                        onChange={() => handleRadioSelect('FOUR_WHEELER_FIRST_PARTY')}
                    />
                    Four Wheeler First Party
                </label>
            </div>
            <div>
                <label>
                    <input
                        type="radio"
                        value="FOUR_WHEELER_THIRD_PARTY"
                        checked={selectedItem === 'FOUR_WHEELER_THIRD_PARTY'}
                        onChange={() => handleRadioSelect('FOUR_WHEELER_THIRD_PARTY')}
                    />
                    Four Wheeler Third Party
                </label>
            </div>

            {selectedItem && renderForm()}
        </div>
    );
};

export default Policy;
