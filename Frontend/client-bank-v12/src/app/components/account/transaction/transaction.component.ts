import { Component, OnInit } from '@angular/core';
import { Transaction } from './../../../model/transaction'
import { TransactionService } from './../../../services/transaction.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-transaction',
  templateUrl: './transaction.component.html',
  styles: [],
  providers: [TransactionService]
})

export class TransactionComponent implements OnInit {

  public transaction: Transaction;
  private errorMessage: string = "";

  constructor(private service: TransactionService,
    private activeRoute: ActivatedRoute, private router: Router) {

    this.transaction = new Transaction();
  }

  ngOnInit(): void {
    this.transaction.accountId = Number(this.activeRoute.snapshot.paramMap.get('id'));
    this.transaction.type = this.activeRoute.snapshot.paramMap.get('type')!;
  }

  ngSubmit() {
    this.proccessTransaction(this.transaction);
  }

  public proccessTransaction(transaction: Transaction) {
    console.log("send transaction ...")
    console.log(transaction)
    this.service.runTransaction(transaction).subscribe(
      response => {
        this.router.navigate(['/dashboard/account']);
      },
      error => { this.errorMessage = <any>error; });
  }
}
