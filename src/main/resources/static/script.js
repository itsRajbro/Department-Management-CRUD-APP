const baseUrl = "http://localhost:8085/departments";

// CREATE
function addDepartment() {
    const name = document.getElementById("name").value;
    const location = document.getElementById("location").value;

    fetch(baseUrl, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name, location })
    })
    .then(() => {
        alert("Department Added");
        getDepartments();
    });
}

// READ
function getDepartments() {
    fetch(baseUrl)
        .then(res => res.json())
        .then(data => {
            const table = document.getElementById("deptTable");
            table.innerHTML = "";

            data.forEach(dept => {
                table.innerHTML += `
                    <tr>
                        <td>${dept.id}</td>
                        <td>${dept.name}</td>
                        <td>${dept.location}</td>
                        <td>
                            <button onclick="deleteDepartment(${dept.id})">
                                Delete
                            </button>
                        </td>
                    </tr>
                `;
            });
        });
}

// UPDATE
function updateDepartment() {
    const id = document.getElementById("updateId").value;
    const name = document.getElementById("updateName").value;
    const location = document.getElementById("updateLocation").value;

    fetch(`${baseUrl}/${id}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name, location })
    })
    .then(() => {
        alert("Department Updated");
        getDepartments();
    });
}

// DELETE
function deleteDepartment(id) {
    fetch(`${baseUrl}/${id}`, {
        method: "DELETE"
    })
    .then(() => {
        alert("Department Deleted");
        getDepartments();
    });
}
