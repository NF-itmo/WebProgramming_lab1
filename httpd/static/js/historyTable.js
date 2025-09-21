class HistoryTable {
	#tableElem;
	#emptyHistoryElem;

	constructor(tableId, emptyHistoryBlockId) {
		this.#tableElem = document.getElementById(tableId);

		this.#emptyHistoryElem = new EmptyBlock(emptyHistoryBlockId);
		this.#emptyHistoryElem.setVisibility(true);
	}

	addHistoryItem(timestamp, elapsedTime, x, y, r, isHitted) {
		this.#emptyHistoryElem.setVisibility(false);

		const row = document.createElement('tr');

        row.innerHTML = `
            <td>${new Date(timestamp).toLocaleString('ru-RU')}</td>
            <td>${elapsedTime} ns</td>
            <td>${x}</td>
            <td>${y}</td>
            <td>${r}</td>
            <td>${isHitted ? 'HIT' : 'MISS'}</td>
        `;
        
        this.#tableElem.prepend(row);
	}

	clear() {
		this.#tableElem.querySelectorAll('tr').forEach((elem) => {
            elem.remove();
        });
        this.#emptyHistoryElem.setVisibility(true);
	}
}

class EmptyBlock {
	#emptyHistoryElem;
	
	constructor(emptyHistoryBlockId) {
		this.#emptyHistoryElem = document.getElementById(emptyHistoryBlockId);
	}

	setVisibility(isVisible) {
		emptyHistory.style.display = isVisible ? 'block' : 'none';
	}
}