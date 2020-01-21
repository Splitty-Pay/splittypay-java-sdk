# Splitty Pay Java Client

Java client to consume [Splitty Pay API](https://documenter.getpostman.com/view/1912948/SW11Xdy5?version=latest).

## Usage

Library artifactory is published on [Maven Central](https://search.maven.org/search?q=a:splittypay-java-sdk).

```xml
<dependency>
  <groupId>com.splittypay</groupId>
  <artifactId>splittypay-java-sdk</artifactId>
  <version>{VERSION}</version>
</dependency>
```

### Sample application

Following code provides a brief example that show how Splitty Pay Client can be used to create a Payment Request.

To generate the access token, visit [Splitty Pay authentication documentation](https://github.com/Splitty-Pay/documentation#Authentication-API).

```java
public class CreatePaymentRequest {

  public static void main(String[] args) {

    private SplittyPayClient splittyPayClient = SplittyPayClient.newSplittyPayClientFor(SplittyPayEnvironment.SANDBOX, {ACCESS_TOKEN});

    PaymentResponse paymentResponse = splittyPayClient.createPayment(PaymentRequest.builder()
                .cart("123")
                .currency("EUR")
                .notificationUrl("https://splittypay.com")
                .cancelUrl("https://errorUrl")
                .successUrl("https://successUrl")
                .amount(10000)
                .details(Details.builder()
                        .email("example@splittypay.com")
                        .language("IT")
                        .build()
                ).build());
    );
  }
}
```

In `src/test` directory can be found more examples that show how Splitty Pay client can be used for the more advanced 
operations.
