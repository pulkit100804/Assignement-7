import cv2

cp = cv2.VideoCapture()
if not cp.isOpened():
    print("Error: Failed to open camera.")
    exit()

cp.set(cv2.CAP_PROP_FRAME_WIDTH, 1280)
cp.set(cv2.CAP_PROP_FRAME_HEIGHT, 720)

while True:
    success, img = cp.read()
    if not success:
        print("Error: Failed to capture frame.")
        break
    
    cv2.imshow("face attendance", img)
    if cv2.waitKey(1) & 0xFF == ord('q'):
        break

cp.release()
cv2.destroyAllWindows()
