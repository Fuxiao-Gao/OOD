package Fee;

/*
functions in interface are implicitly public abstract
 */
public interface PaymentObserver {
    void update(Payment payment);
}
