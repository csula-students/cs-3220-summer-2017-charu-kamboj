// single state store
class Store {
    // these are the key name you can use in Store
    

    constructor (storage) {
        this.storage = storage; // assuming local storage will be passed in as storage
        this.CART_KEY = 'CART';
    this.QUEUE_KEY = 'QUEUE';
    this.FOODS_KEY = 'FOODS';
    }

    // you can get item by store.cartItems
    get cartItems () {
        return JSON.parse(this.storage.getItem(this.CART_KEY));
    }

    // to call setter, simply "assign" like store.cartItems = something
    set cartItems (cartItems) {
        this.storage.setItem(this.CART_KEY, JSON.stringify(cartItems));
    }

    get queue () {
         return JSON.parse(this.storage.getItem(this.QUEUE_KEY));
    }

    set queue (queue) {
this.storage.setItem(this.QUEUE_KEY, JSON.stringify(queue));
    }

    get foods () {
 return JSON.parse(this.storage.getItem(this.FOODS_KEY));
    }

    set foods (foods) {
        this.storage.setItem(this.FOODS_KEY, JSON.stringify(foods));
    }
}

class Cart {
    // take dom element into JavaScript class to attachment events
    constructor(root, store) {
        this.root = root;
        this.store = store;
        this.items=this.store.cartItems;
        this.init();
    }

    init () {
        // Render a list of items under root element
        this.render();
        // TODO: attach all necessary events
    }

    destroy () {
        // TODO: remove all the events attached from init
    }

    // remove an item from shopping cart
    removeItem (item) {
        // TODO: logic to remove an item from cart
        // call render method when the item is removed to update view
		alert("You are trying to delete an Item from the cart!");
         var fill = this.items;
        fill = fill.filter(a => a != fill[item]);
        console.log(fill);

        this.store.cartItems = fill;
		window.location.reload();
        this.render();
    }

    placeOrder () {
        // add item to statuses in store as status "in progress"
    }

    // render a list of item under root element
    render () {
		

        console.log(this.store.cartItems);
        let tbody = this.root.querySelector('tbody');
        // using innerHTML to render a list of table row item under tbody
        var dataset = this.store.cartItems;
		

        for (var i = 0; i < dataset.length; i++) {
            tbody.innerHTML += `<tr class="item">
            <td>${dataset[i].name}</td>
            <td>${dataset[i].price}</td>
            
            <td><button class="delete-button" data-index=${i} >Remove</button></td>
        </tr>`
        }



        let deletebutton = document.querySelectorAll('.delete-button');
        deletebutton.forEach(btn => {
            btn.addEventListener('click', () => {
				


                this.removeItem(btn.dataset.index);
            });
        });
    }
}

class  CheckoutButton{
    constructor(root, store) {
        this.root = root;
        this.store = store;
        this.onClick = () => this.addItemToCart();
        this.init();
    }

    init () {
         this.root.addEventListener('click', this.onClick);
    }

    destroy () {

    }

    addItemToCart () {
        // hint: you can use `dataset` to access data attributes
        // See passing data from HTML to JavaScript from course note
        let cartItems = this.store.cartItems || [];
		
        // TODO: replace with actual item
        console.log(this.root.dataset);
		
		
        cartItems.push({
            name:this.root.dataset.name,
            price:this.root.dataset.price,
            
        
        });
		
        console.log(cartItems);
        this.store.cartItems = cartItems;
    }
}

class StatusTable {
    // take dom element into JavaScript class to attachment events
    constructor(root, store) {
        this.root = root;
        this.store = store;
        init();
    }

    init () {
        // attach click event listener to table header row on each column
        render();
    }

    destroy () {
        // remove all the events attached from init
    }

    sort (columnName) {
        // after sorting the array of statuses, re render item to update view
        render();
    }

    // render rows of items under table using root.innerHTML
    render () {

    }
}


// continue from Lab2 with Store, CheckoutButton, Cart components
class Inventory {
    constructor(root, store) {
        this.root = root;
        this.store = store;
        this.init();
    }

    init () {
        this.render();
        // TODO: attach event listeners like click to remove items after rendering
    }

    destroy () {
        // TODO: remove event listeners added from the init above
       let removeInventoryButtons = document.querySelectorAll('.removebutton');
            for (var i = 0; i < removeInventoryButtons.length; i++) {
                let btn = removeInventoryButtons[i];
                btn.removeEventListener('click', () => {
                    let item = this.store.foods[parseInt(btn.dataset.index)];
                    this.removeItem(item);
                });
            }
    }

    removeItem (itemName) {
        // TODO: function to remove item given item name from store
         if (this.store.foods !== null) {
                var updated_list = [];
                var to_compare = itemName.name;
                for (var i = 0; i < this.store.foods.length; i++) {
                    if (this.store.foods[i].name !== to_compare) {
                        updated_list.push(this.store.foods[i]);
                    }
                }
                this.store.foods = updated_list;
            }
            this.render();
    }

    render () {
        // using innerHTML to render inventory listing
        let foodbody=this.root.querySelector('tbody');
        foodbody.innerHTML='';
        if(this.store.foods===null){
            this.store.foods=[];
        }
        for(var i=0;i<this.store.foods.length;i++){
            var food_name=this.store.foods[i].name;
            var food_img=this.store.foods[i].image;
            var food_description=this.store.foods[i].description;

            foodbody.innerHTML +=
           
                    `<tr >
                     <td>${food_name}</td>
                        <td>
                            <img src="${food_image}">
                        </td>
                        <td>${food_description}
                        </td>
                        <td>
                            <button class="removebutton" data-index=${i}>Remove item from Inventory</button>
                         </td>
                      </tr>`;
        }
        let removeButton=document.querySelectorAll('.removebutton');
        for(var i=0;i<removeButton.length;i++){
            let buttn=removeButton[i];
            buttn.addEventListener('click',()=>{
                let item=this.store.foods[parseInt(buttn.dataset.index)];
                this.removeItem(item);
            }
                );
            }
        }
    }


class Menu {
    constructor(root, store) {
        this.root = root;
        this.store = store;
        this.init();
    }

    init () {
        this.render();
    }

    render () {
        // TODO: render a list of food menu from store using innerHTML
    // using innerHTML to render inventory listing
            let tbody = this.root.querySelector('tbody');
            // using innerHTML to render a list of table row item under tbody
            tbody.innerHTML = ``;
            if (this.store.foods === null) {
                this.store.foods = [];
            } 
            for (var i = 0; i < this.store.foods.length; i++) {
                // for each item in local storage's FOODS, create a row with a cell for the item name and image, and one for description.
                var food_name = this.store.foods[i].name;
                var food_image = this.store.foods[i].image;
                var food_description = this.store.foods[i].description;

                tbody.innerHTML +=
                    `<tr >
                     <td>${food_name}</td>
                        <td>
                            <img src=${food_image}>
                        </td>
                        <td>${food_description}
                        </td>
                        <td>
                            <button class="checkout-button" data-index=${i}>Add item to cart</button>
                         </td>
                      </tr>`;
            }

            let checkoutButtons =document.querySelectorAll('.checkout-button');
            if(checkoutButtons&& checkoutButtons.length){
                for(var i=0;i<checkoutButtons.length;i++){
                    new CheckoutButton(checkoutButtons[i], this.store,this.cart);
                }
            }


    }
}

class CreateFood {
    constructor(root, store) {
        this.root = root; // root should be the container of the form itself
        this.store = store;
        this.init();
    }

    init () {
        // attach click event to create button
        let Add_foodbutton=document.getElementById('Add_food');
        if(Add_foodbutton){
            Add_foodbutton.addEventListener("click",()=>{

                this.createFood();
            }


                )
            document.getElementById("").innerHTML='';
            
        }
    }

    createFood () {
        // will need to do querySelector to find out every single form element
        // to get their values before creating a new food
        // after creating a new food item, add it to store
        let store_food=this.store.foods || [];
        var food_name=document.getElementById('food_name');
        var food_image=document.getElementById('food_img');
        var description=document.getElementById('food_description');
        var pushing={name:food_name,image:food_image,description:description};

        var boolean=true; 
        for(var i=0;i<store_food.length;i++){
            if(pushing.name===store_food[i].name)
                boolean=false;
                break;
            
        }
        if(boolean){
            store_food.push(pushing);
            this.store.foods=store_food;
        }
        for(var i=0;i<pushing.length;i++)
        console.log(pushing);

    }
}
// DOMContentLoaded event will allow us to run the following function when
// everything is ready. Think of the following code will only be executed by
// the end of document
document.addEventListener('DOMContentLoaded', () => {
        // use querySelector to find the table element (preferably by id selector)
        let statusTable = document.querySelector('.order_status_table');
        // // use querySelector to find the cart element (preferably by id selector)
        let cart = document.querySelector('.cart-table');
        let checkoutButtons = document.querySelectorAll('.addfood');

        // finding the form element to createFood
        let createFood = document.querySelector('.form_food');
        let inventory = document.querySelector('.Inventory');
        let menu = document.querySelector('.menu_table');

        let store = new Store(window.localStorage);

        if (statusTable) {
            new StatusTable(statusTable, store);
        }
        if (cart) {
            var cartVar = new Cart(cart, store);
        }
        if (checkoutButtons && checkoutButtons.length) {
            for (var i = 0; i < checkoutButtons.length; i++) {
                new CheckoutButton(checkoutButtons[i], store, cartVar);
            }
        }

        if (createFood) {
            new CreateFood(createFood, store);
        }
        if (inventory){
            new Inventory(inventory, store);
        }
        
        if (menu) {
        new Menu(menu, store, cartVar);
    }
    });