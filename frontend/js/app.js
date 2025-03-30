const BASE_URL = 'http://localhost:8080/api/trains';

document.addEventListener("DOMContentLoaded", () => {
    fetch(BASE_URL)
        .then(response => response.json())
        .then(data => {
            const trainList = document.getElementById("train-list");
            trainList.innerHTML = data.map(train => `<p>${train.trainName} - ${train.source} to ${train.destination} (${train.seats} seats)</p>`).join('');
        });

    const trainForm = document.getElementById("trainForm");
    if (trainForm) {
        trainForm.addEventListener("submit", event => {
            event.preventDefault();
            const train = {
                trainName: document.getElementById("trainName").value,
                source: document.getElementById("source").value,
                destination: document.getElementById("destination").value,
                seats: document.getElementById("seats").value
            };

            fetch(BASE_URL, {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(train)
            }).then(() => location.reload());
        });
    }
});
