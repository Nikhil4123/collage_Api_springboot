import React, { useState } from 'react';
import axios from 'axios';
import './AddCourse.css'; // Import the CSS file

const AddCourse = () => {
  const [name, setName] = useState('');
  const [accommodationFee, setAccommodationFee] = useState('');
  const [duration, setDuration] = useState('');
  const [collegeId, setCollegeId] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await axios.post('/api/addcourse', {
        name,
        accommodationFee: parseFloat(accommodationFee),
        duration: parseInt(duration),
        collegeId: parseInt(collegeId),
      });
      setName('');
      setAccommodationFee('');
      setDuration('');
      setCollegeId('');
      alert('Course added successfully!');
    } catch (error) {
      alert('Error adding course');
    }
  };

  return (
    <div className="add-course-container">
      <h2>Add Course</h2>
      <form onSubmit={handleSubmit} className="course-form">
        <input
          type="text"
          value={name}
          onChange={(e) => setName(e.target.value)}
          placeholder="Course Name"
          required
        />
        <input
          type="number"
          value={accommodationFee}
          onChange={(e) => setAccommodationFee(e.target.value)}
          placeholder="Accommodation Fee"
          required
        />
        <input
          type="number"
          value={duration}
          onChange={(e) => setDuration(e.target.value)}
          placeholder="Duration (in years)"
          required
        />
        <input
          type="number"
          value={collegeId}
          onChange={(e) => setCollegeId(e.target.value)}
          placeholder="College ID"
          required
        />
        <button type="submit">Add Course</button>
      </form>
    </div>
  );
};

export default AddCourse;
