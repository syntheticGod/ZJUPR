package presentation.ita1;

public class NumberFormatTest {
   public static void main(String args[]){
	  System.out.println(NumberValidationUtils.isPositiveDecimal("1.2")) ;
	  System.out.println(NumberValidationUtils.isPositiveDecimal("xxr")) ; 
	  System.out.println(NumberValidationUtils.isPositiveDecimal("66")) ;
	  System.out.println(NumberValidationUtils.isPositiveDecimal("-5")) ;
	  System.out.println(NumberValidationUtils.isPositiveDecimal("-5.3")) ;
	  System.out.println(NumberValidationUtils.isPositiveInteger("66")) ;
	  System.out.println(NumberValidationUtils.isPositiveInteger("")) ;
	  System.out.println(NumberValidationUtils.isPositiveInteger("0")) ;
	  System.out.println(StocksSearchInfoChecker.checkInfoOrder("asd",""));
	  System.out.println(StocksSearchInfoChecker.checkInfoOrder("1","2.3"));
	  System.out.println(StocksSearchInfoChecker.checkInfoOrder("1.1","0"));
	  System.out.println(StocksSearchInfoChecker.checkInfoOrder("0","4"));
	 /* 
	  System.out.println(StocksSearchInfoChecker.checkDateOrder("2016-01-01", "2016-01-01")) ;
	  System.out.println(StocksSearchInfoChecker.checkDateOrder("2016-02-01", "2016-01-01")) ;
	  System.out.println(StocksSearchInfoChecker.checkDateOrder("2016-02-01", "2016-02-01")) ;
	  */
   }
}
