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

   [Awair Repository Link]([https://github.com/your-username/awair](https://github.com/RizkyFahrizal/capstone-project-C242-PS434/edit/main/cc/capstone-pawon-backend))

## Additional Sections (Optional)

**You can add more sections as needed, such as:**

### Installation

**Instructions on how to install your project:**

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/your-username/your-project.git](https://github.com/your-username/your-project.git)
