function accountActive() {

  let account = document.getElementById('account')
  if (account) {
    account.addEventListener('click' , () => {
      account.parentElement.classList.toggle('active')
    })
  }
}

// $(function() {
//   alert('Hello, custom js');
// });
