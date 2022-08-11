export class Account{

  public idAccount?: number;
  public totalAmount?:number;
  public idCustomer?:number;
  public customer?:Customer;

  constructor(){
    // this.idaccount =0;
    // this.totalamount =0;
    // this.idcustomer =0;
    // this.customer = new Customer();
  }
}

export class Customer{

  public idCustomer?:number;
  public fullName?:string;
  public email?:string;

  constructor(){
    // this.idcustomer =0;
    // this.fullname ="";
    // this.email ="";
  }
}
