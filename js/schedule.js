const API_BASE =
window.location.hostname === "localhost"
 ? "http://localhost:8081/api"
 : "https://veltroz-company-website.onrender.com/api";
async function scheduleCall() {

    const data = {
        fullName: document.getElementById("name").value.trim(),
        email: document.getElementById("email").value.trim(),
        phone: document.getElementById("phone").value.trim(),
        scheduledTime: document.getElementById("time").value,
        message: document.getElementById("message").value.trim()
    };

    console.log("Sending:", data);

    try {

        const response = await fetch(
            API_BASE + "/schedule",
            {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(data)
            }
        );

        console.log("Status:", response.status);

        const result = await response.text();

        console.log("Response:", result);

        alert("Schedule submitted successfully!");

    } catch (error) {

        console.error("Fetch Error:", error);

        alert("Schedule Failed");
    }
}