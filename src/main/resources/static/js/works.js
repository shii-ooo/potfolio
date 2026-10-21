
fetch("/api/works")
    .then(response => response.json())
    .then(works => {
        const worksList = document.querySelector("#worksList");

        works.forEach(work => {
            const workElement = document.createElement("div");
            workElement.className = "work";

            const imageElement = document.createElement("div");
            imageElement.className = "image";

            const img = document.createElement("img");
            img.src = `/api/works/${work.id}/image`;
            img.alt = work.title;

            imageElement.appendChild(img);

            const titleElement = document.createElement("p");
            titleElement.textContent = work.title;

            workElement.appendChild(imageElement);
            workElement.appendChild(titleElement);

            worksList.appendChild(workElement);
        });
    })
    .catch(error => {
        console.error("作品一覧の取得に失敗しました", error);
    });
