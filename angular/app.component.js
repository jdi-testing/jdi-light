function Item(purchase, price, done) {
    this.purchase = purchase;
    this.price = price;
    this.done = done;
}
 
var AppComponent = ng.core.Component({
    selector: 'my-app',
    template:  `<div class="page-header">
        <h1> Список покупок </h1>
    </div>
    <div class="panel">
        <div class="form-inline">
            <div class="form-group">
                <div class="col-md-8">
                    <input class="form-control" [(ngModel)]="text" placeholder = "Название" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-6">
                    <input type="number" class="form-control" [(ngModel)]="price" placeholder="Цена" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-md-offset-2 col-md-8">
                    <button class="btn btn-default" (click)="addItem(text, price)">Добавить</button>
                </div>
            </div>
        </div>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Предмет</th>
                    <th>Цена</th>
                    <th>Куплено</th>
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
            new Item("Хлеб",15.9),
            new Item("Масло",60),
            new Item("Картофель",22.6, true),
            new Item("Сыр",310)
        ];
    }
});
 
AppComponent.prototype.addItem = function (text, price) {
        if (text == undefined || text.trim() == "" || price == undefined)
            return;
        this.items.push(new Item(text, price));
};