
    fetch("/api/topics")
    .then(response => response.json())
    .then(works => {
        
        const topicsList = document.querySelector("#topicsList");

        works.forEach(work => {

            const topicElement = document.createElement("div");
            topicElement.className = "topic";

            const h2 = document.createElement("h2");
            h2.textContent = work.title;

            topicElement.appendChild(h2);

            const contentElement = document.createElement("p");
            contentElement.textContent = work.content;

            topicElement.appendChild(contentElement);

            const dateElement = document.createElement("p");
            const date = new Date(work.created_at);
            dateElement.textContent = date.getFullYear() + "." +
                String(date.getMonth() +1).padStart(2,"0") + "." +
                String(date.getDate()).padStart(2,"0");

            topicElement.appendChild(dateElement);

            topicsList.appendChild(topicElement);
        });
    })
    .catch(error => {
        console.error("作品一覧の取得に失敗しました", console.error);
    });
