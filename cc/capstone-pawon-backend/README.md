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
