async function adminLogin() {
    const adminName = document.getElementById('adminName').value;
    const adminPassword = document.getElementById('adminPassword').value;
    
    const response = await fetch(`http://localhost:8080/adminlogin?adminName=${adminName}&adminPassword=${adminPassword}`);
    const data = await response.json();
    
    if (data.statusCode === 200) {
        alert('Login Successful! Redirecting to Admin Dashboard...');
        window.location.href = 'dashboard.html';
    } else {
        alert('Invalid Credentials');
    }
}

async function registerEmployee() {
    const employee = {
        fname: document.getElementById('fname').value,
        lname: document.getElementById('lname').value,
        email: document.getElementById('email').value,
        salary: document.getElementById('salary').value,
        department: document.getElementById('department').value,
        designation: document.getElementById('designation').value,
        joiningDate: document.getElementById('joiningDate').value
    };

    const response = await fetch("http://localhost:8080/register", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(employee)
    });

    const data = await response.json();
    alert(data.message);
}

async function fetchAllEmployees() {
    const response = await fetch("http://localhost:8080/get"); // Fetch employee data
    const data = await response.json();

    const tableBody = document.getElementById("employeeList");
    tableBody.innerHTML = ""; // Clear existing table data
    let sortedEmployees = data.data.sort((a, b) => a.id - b.id);

    sortedEmployees.forEach(emp => {
        let row = `<tr>
            <td>${emp.id}</td>
            <td>${emp.fname}</td>
            <td>${emp.lname}</td>
            <td>${emp.email}</td>
            <td>${emp.salary}</td>
            <td>${emp.department}</td>
            <td>${emp.designation}</td>
            <td>${emp.joiningDate}</td>
        </tr>`;
        tableBody.innerHTML += row;
    });
}

async function fetchEmployeeById() {
    const empId = document.getElementById('empId').value;
    const response = await fetch(`http://localhost:8080/getEmpByid?id=${empId}`);
    const data = await response.json();

    const tableBody = document.getElementById("employeeDetails");
    tableBody.innerHTML = ""; // Clear previous result

    if (data) {
        let row = `<tr>
            <td>${data.id}</td>
            <td>${data.fname}</td>
            <td>${data.lname}</td>
            <td>${data.email}</td>
            <td>${data.salary}</td>
            <td>${data.department}</td>
            <td>${data.designation}</td>
            <td>${data.joiningDate}</td>
        </tr>`;
        tableBody.innerHTML = row;
    } else {
        alert("Employee not found!");
    }
}
async function updateEmployee() {
    const employee = {
        id: document.getElementById('updateId').value,
        fname: document.getElementById('updateFname').value,
        lname: document.getElementById('updateLname').value,
        email: document.getElementById('updateEmail').value,
        salary: document.getElementById('updateSalary').value,
        department: document.getElementById('updateDepartment').value,
        designation: document.getElementById('updateDesignation').value,
        joiningDate: document.getElementById('updateJoiningDate').value
    };

    const response = await fetch("http://localhost:8080/update", {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(employee)
    });

    const data = await response.json();
    alert(data.message);
}

async function deleteEmployee() {
    const empId = document.getElementById('deleteId').value;
    const response = await fetch(`http://localhost:8080/delete?id=${empId}`, { method: "DELETE" });
    
    const data = await response.text();
    document.getElementById("deleteMessage").innerHTML = `<p>${data}</p>`;
}
