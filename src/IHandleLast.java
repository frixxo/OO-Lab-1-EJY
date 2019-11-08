public interface IHandleLast <T> {
   void load(T object) throws Exception;
    T release() throws Exception;
}
