import React, { useEffect, useState } from 'react';
import axios from 'axios';

const CollegeList = () => {
  const [colleges, setColleges] = useState([]);

  useEffect(() => {
    const fetchColleges = async () => {
      const response = await axios.get('/api/getallcollage');
      setColleges(response.data);
    };
    fetchColleges();
  }, []);

  return (
    <div>
      <h2>Colleges</h2>
      <ul>
        {colleges.map((college) => (
          <li key={college.id}>{college.name}</li>
        ))}
      </ul>
    </div>
  );
};

export default CollegeList;
