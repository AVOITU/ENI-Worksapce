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
        }else if ((paswwordLength >= 7 && paswwordLength <= 9)) {
        item.innerText = "Mot de passe moyen";
        span.style.backgroundColor = "orange";
      } else {
        item.innerText = "Mot de passe fort";
        span.style.backgroundColor = "green";
      };
  });
}

function localUsers() {
  
  const btnComptCreation = document.getElementById("btnComptCreation");
  console.log(btnComptCreation);
  btnComptCreation.addEventListener("click", function(){
    btnComptCreation. preventDefault()
  })

  localStorage.setItem('prenom', 'Sylvain')
  let prenom = localStorage.getItem('prenom')
  console.log(prenom) 
  sessionStorage.setItem('age', 25)
  let age = sessionStorage.getItem('age')
  console.log(age)
  }