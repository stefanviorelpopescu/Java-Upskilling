package concurrency._2_lack_of_coordination;

public class Producer extends Thread {

  private IChannel channel;

  public Producer(IChannel channel) {
    this.channel = channel;
  }

  @Override
  public void run() {
    for (int i = 1; i <= 1000; i++) {
      channel.put(String.valueOf(i));
    }
    channel.put("DONE");
  }
}
