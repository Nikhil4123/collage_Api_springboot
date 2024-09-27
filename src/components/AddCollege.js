import React, { useState } from 'react';
import axios from 'axios';

const AddCollege = () => {
  const [name, setName] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post('/api/addcollage', { name });
      setName('');
      alert('College added successfully!');
    } catch (error) {
      alert('Error adding college');
    }
  };

  return (
    <div>
      <h2>Add College</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          value={name}
          onChange={(e) => setName(e.target.value)}
          placeholder="College Name"
          required
        />
        <button type="submit">Add</button>
      </form>
    </div>
  );
};

export default AddCollege;
