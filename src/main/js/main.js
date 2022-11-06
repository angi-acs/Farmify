
const inputText = document.querySelector("#txt");
const myButton = document.querySelector('.btn-list');
const list = document.querySelector('.container-leg ul');
myButton.addEventListener('click', (e)=>{
    if(inputText.value !=""){
        e.preventDefault();
        // create li
        const myLi = document.createElement("li");
        myLi.innerHTML = inputText.value;
        list.appendChild(myLi);
        // create span
        const mySpan = document.createElement('span');
        mySpan.innerHTML = 'x';
        myLi.appendChild(mySpan);
    }
    const close = document.querySelectorAll('.container-leg span');
    for (let i=0; i<close.length; i++){
        close[i].addEventListener('click', ()=>{
            close[i].parentElement.style.opacity = 0;
            setTimeout(()=>{
                close[i].parentElement.style.display="none";

            }, 500);
        })
    }
    inputText.value = "";
});

const inputText2 = document.querySelector("#txt2");
const myButton2 = document.querySelector('.btn-list2');
const list2 = document.querySelector('.container-fruc ul');
myButton2.addEventListener('click', (e)=>{
    if(inputText2.value !=""){
        e.preventDefault();
        // create li
        const myLi2 = document.createElement("li");
        myLi2.innerHTML = inputText2.value;
        list2.appendChild(myLi2);
        // create span
        const mySpan2 = document.createElement('span');
        mySpan2.innerHTML = 'x';
        myLi2.appendChild(mySpan2);
    }
    const close2 = document.querySelectorAll('.container-fruc span');
    for (let i=0; i<close2.length; i++){
        close2[i].addEventListener('click', ()=>{
            close2[i].parentElement.style.opacity = 0;
            setTimeout(()=>{
                close2[i].parentElement.style.display="none";

            }, 500);
        })
    }
    inputText2.value = "";
});

const result = document.querySelector("#color");
const myButton3 = document.querySelector('.btn-list3');

async function sendJSON() {

    myJSON = { "color" : result.value };
    const response = await fetch("http://localhost:8080/api/site/add", {
    method: 'POST',
    headers: {
         'Accept': 'application/json',
        'Content-Type': 'application/json'
        },
    body: JSON.stringify(myJSON),
        });
        response.json().then(data=> {console.log(data);
        });
}

// GET PICTURE

//get form, submit button and an empty div for image inserting
const   form = document.getElementById("formPic"),
        btn = document.getElementById("submitPic");

btn.addEventListener('click', async (event)=>{
    //prevent redirect
    event.preventDefault();

    //get file
    let uplImg = form.file.files[0];

    //check for file type
    if (uplImg.type.substr(0,5) !== "image"){
        console.error("Only images");
        return;
    }

    img = document.createElement("img");

    //convert uploaded image to base 64
    let imageData = await getBase64(uplImg);
    sendPic(imageData);

})

async function sendPic(imgData) {
    myJSON = { "data" : imgData};
    console.log(imgData);
    const response = await fetch("http://localhost:8080/api/site/pic", {
        method: 'POST',
        headers: {
             'Accept' : 'application/json',
            'Content-Type': 'application/json'
            },
        body: JSON.stringify(myJSON),
            });
            response.json().then(data=> {console.log(data);
            });
}

// convert image to base 64
function getBase64(file) {
    return new Promise((resolve, reject) => {
      const reader = new FileReader();
      reader.readAsDataURL(file);
      reader.onload = () => resolve(reader.result);
      reader.onerror = error => reject(error);
    });
}

const root_theme = document.querySelector(':root');

// seleting the button which will trigger the event
const root_btn = document.querySelector('.btn-primary');

// the event listener to change the text color upon 'click'
root_btn.addEventListener('click', () => {
    // changing the color from #0b32e7 to #f44336
    root_theme.style.setProperty('--blue', 'turquoise');
});