export default class MessageController {
  constructor() {
    this.messageView = document.getElementById("message");
  }

  showMessage(message) {
    this.messageView.innerHTML = message;
  }

  eraseMessage() {
    this.messageView.innerHTML = "";
  }
}
