# Face-Detction-with-Kafka

A simple analytics solution was carried out which detects the face in a live video
A simple project of face detection was referred from the OpenCV library which was integrated with Kafka. For this a new independent 
solution was developed based on the same principle as that of the live streaming consumer application. 
The solution is made up of a broadcasting application(which is already added) and this project is a consumer application that is responsible 
for carrying out analytics. Consumer application consume these frames as a String from Kafka. Then, tranform to the Mat object and serves
it to Face Dection algo in order to carry out analytics. Please refer to the below Screenshot : Consumer application.

![Consumer](https://user-images.githubusercontent.com/40739676/72950376-1923ad00-3d83-11ea-9be7-c60d833d2347.PNG)





Finally these frames after processing, will be rendered in a video container built in JavaFX.

This solution isn’t integrated into the final solution due to one limitation. The "Live-video-Broadcasting-Application-Analytics" transforms each Mat as a string via JSON. 
The conversion of frame is quite big(1.2 MB) and it leads to a time lag. Currently I have tried to descale the Mat to 800 KB but I will try to improve this solution before integrating analytics with "Live-Video-Streaming-Application". 


The future scope of this project is to build a solution to exhibit resuabilty of Kafka by allowing a publisher application to produce data for multiple consumers.For example Analytics , Live Streaming and Re-streaming.
 The optimal way to build On-demand solution is to consuumer frames from kafka and creates Scenes(which are chunks of frames) which is stored
 in either Object store (MinIO or S3) or file storage (for example HLS) to re-stream the Video .Please refer to the below screenshot showing Kafka depicting resuablity.
 
 ![Enhancements](https://user-images.githubusercontent.com/40739676/72951170-6c96fa80-3d85-11ea-964d-6c0f679bcf5a.PNG)
