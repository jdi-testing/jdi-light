function Item(purchase, price, done) {
    this.purchase = purchase;
    this.price = price;
    this.done = done;
}
 
var AppComponent = ng.core.Component({
    selector: 'my-app',
    template:  `<div class="page-header">
        <h1> Shopping List </h1>
    </div>
    <div class="panel">
        <div class="form-inline">
            <div class="form-group">
                <div class="col-md-8">
                    <input class="form-control" [(ngModel)]="text" placeholder = "Item" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-6">
                    <input type="number" class="form-control" [(ngModel)]="price" placeholder="Price" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-offset-2 col-md-8">
                    <button class="btn btn-default" (click)="addItem(text, price)">Add</button>
                </div>
            </div>
        </div>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Item</th>
                    <th>Price</th>
                    <th>Bought</th>
                </tr>
            </thead>
            <tbody>
                <tr *ngFor="let item of items">
                    <td>{{item.purchase}}</td>
                    <td>{{item.price}}</td>
                    <td><input type="checkbox" [(ngModel)]="item.done" /></td>
                </tr>
            </tbody>
        </table>
    </div>`
    })
  .Class({
    constructor: function() { 
     
        this.items= [
            new Item("Bread",15.9),
            new Item("Butter",60),
            new Item("Potatoes",22.6, true),
            new Item("Cheese",310)
        ];
    }
});
 
AppComponent.prototype.addItem = function (text, price) {
        if (text == undefined || text.trim() == "" || price == undefined)
            return;
        this.items.push(new Item(text, price));
};