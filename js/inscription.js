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

