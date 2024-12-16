# capstone-project-C242-PS434

Team composition \
☁ CC = 2 members \
📱 MD = 2 members \
📅 ML = 3 members

# deploy back-end part with Cloud Run

1. Build Docker by dockerfile

```bash
docker build -t gcr.io/[PROJECT_ID]/[SERVICE_NAME] .
```

2. Create image for docker

```bash
 docker push gcr.io/[PROJECT_ID]/[SERVICE_NAME]
```

3. Deploy it!

```bash
   gcloud run deploy [SERVICE_NAME] \
    --image gcr.io/[PROJECT_ID]/[SERVICE_NAME] \
    --tag [YOUR_TAG] \
    --region [REGION] \
    --allow-unauthenticated
```

## Video Demo

[Video Demo Link](https://youtu.be/bK7u9zx-y_o)

## Our Repositories

- **Awair**

   [Awair Repository Link](https://github.com/RizkyFahrizal/capstone-project-C242-PS434/edit/main/cc/capstone-pawon-backend)
