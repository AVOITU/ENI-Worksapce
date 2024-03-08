function mdpSecurity() {
  const inputPassword = document.getElementById("mdp");
  const item = document.createElement("p");
  const span = document.createElement("span");
  item.className = "ajoutjs";
  span.className = "securityAdviceColor";
  inputPassword.insertAdjacentElement("afterend", span);
  inputPassword.insertAdjacentElement("afterend", item);

  inputPassword.addEventListener("input", function () {
    let paswwordLength = inputPassword.value.length;
    if (paswwordLength < 7) {
      item.innerText = "Mot de passe faible";
      span.style.backgroundColor = "red";
    } else if (paswwordLength >= 7 && paswwordLength <= 9) {
      item.innerText = "Mot de passe moyen";
      span.style.backgroundColor = "orange";
    } else {
      item.innerText = "Mot de passe fort";
      span.style.backgroundColor = "green";
    }
  });
}

function localUsers() {
  const getForm = document.querySelector("form");
  getForm.addEventListener("submit", handleForm);

  function handleForm(e) {

    e.preventDefault();

    const infoUser = ["nomUtilisateur", "email", "mdp", "passwordVerification"];
    let index=0

    infoUser.forEach((element) => {
      console.log(index);
      index=index+1
      let objectUser={}
      const storageUsers = []; 
      let getInput = document.getElementById(element).value;

      objectUserdata(index , objectUser, getInput, storageUsers)
    });
  };

  function objectUserdata(index, objectUser, getInput, storageUsers) {   
  
    localStorage.setItem(index, getInput);
    objectUser[index]= getInput;
    storageUsers.push(objectUser)
    console.log(storageUsers);
  }
};

function testExistingUser() {
  
}

function init() {
  mdpSecurity();
  localUsers();
}