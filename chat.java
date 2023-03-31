const messageList = document.getElementById('message-list');
const messageForm = document.getElementById('message-form');
const messageInput = document.getElementById('message-input');

messageForm.addEventListener('submit', event => {
	event.preventDefault();
	const message = messageInput.value;
	if (message.trim()) {
		appendMessage(`You: ${message}`);
		messageInput.value = '';
	}
});

function appendMessage(message) {
	const div = document.createElement('div');
	div.className = 'message';
	const userSpan = document.createElement('span');
	userSpan.className = 'user';
	userSpan.textContent = message.split(': ')[0];
	const textSpan = document.createElement('span');
	textSpan.textContent = message.split(': ')[1];
	const timeSpan = document.createElement('span');
	timeSpan.className = 'time';
	timeSpan.textContent = getTime();
	div.appendChild(userSpan);
	div.appendChild(textSpan);
	div.appendChild(timeSpan);
	messageList.appendChild(div);
	messageList.scrollTop = messageList.scrollHeight;
}

function getTime() {
	const now = new Date();
	const hours = now.getHours().toString().padStart(2, '0');
	const minutes = now.getMinutes().toString().padStart(2, '0');
	return `${hours}:${minutes}`;
}

appendMessage('Bot: Welcome to the chat!'); // Initial message
