(function (){
    let root = shadowContainer.attachShadow( { mode: "open" } )

//Inside element
    var h1 = document.createElement( "h1" )
    h1.textContent = "Inside Shadow DOM"
    h1.id = "shadowTitle"
    root.appendChild( h1 )

    let btn = document.createElement( "button" )
    btn.textContent = "Button inside Shadow DOM"
    btn.id = "shadowBtn"
    btn.onclick = function(){
        shadowContainer.shadowRoot.querySelector("#shadowTxt").textContent = "Button was clicked"
    }
    root.appendChild( btn )

    let txt = document.createElement( "p" )
    txt.textContent = "Text inside Shadow DOM"
    txt.id = "shadowTxt"
    root.appendChild( txt )
})()