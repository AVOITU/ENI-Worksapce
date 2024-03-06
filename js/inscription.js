// avec un niveau de difficulté du mot de passe faible, moyen, fort.
// Règles : si le mot de passe contient moins de 6 caracteres il est faible.
// S'il contient plus de 6 caracteres avec un symbole ou un nombre il est moyen.
// S'il contient plus de 9 caracteres avec un symbole et un nombre il est fort.

// Mettre en place une écoute sur le mdp

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

