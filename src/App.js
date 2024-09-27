import React from 'react';
import AddCollege from './components/AddCollege.js';
import CollegeList from './components/CollegeList.js';
import AddCourse from './components/AddCourse.jsx';


function App() {
  return (
    <div className="App">
      <h1>College Management System</h1>
      <AddCollege />
      <CollegeList />
      <AddCourse />
    </div>
  );
}

export default App;
