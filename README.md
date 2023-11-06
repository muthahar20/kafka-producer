# kafka-producer

==> Apache Kafka Instalaction Steps as follows:

1. Download Kafka from the official website at https://kafka.apache.org/downloads

2. unzip and move kafkat downloded folder to target location ( where you want store kafka source folder and run it )

3. Start Zookeepter service

  > bin/zookeeper-server-start.sh config/zookeeper.properties

4. Start Kafka broker

  > bin/kafka-server-start.sh config/server.properties

5. Create topic using below given commends 

  > bin/kafka-topics.sh --create --topic <topic_name> --bootstrap-server localhost:9092

6. once topic created then Product the message by using below given commands

  > bin/kafka-console-producer.sh --topic  <topic_name> --bootstrap-server localhost:9092

7. Once you run the command, you’ll see that your terminal window is waiting for input. Write your first message and hit Enter.

  > my first message
  > test_message-1
  > test_message-2

8. using  <topic_name> we can consume all messages from producer by using below given commands 

  > bin/kafka-console-consumer.sh --topic  <topic_name> --from-beginning --bootstrap-server localhost:9092 --group notif-consumer







