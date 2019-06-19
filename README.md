# Kubeboot

Deploy a springboot app to kubernetes.

## Which online resources did you rely on?

- Kubernetes interactive in-browser walk-through: https://kubernetes.io/docs/tutorials/kubernetes-basics/

- Deploying a springboot app to kubernetes with minikube:
https://gorillalogic.com/blog/build-and-deploy-a-spring-boot-app-on-kubernetes-minikube/

## How Do I install the stuff?

- You need `kubectl` and `minikube`. These can both be installed with 
brew.

- `brew install kubernetes-cli`

- `brew cask install minikube`

## How do I prepare the cluster?

- Minikube is for making local clusters. I started one with the command 
`minikube start`. This will also make `kubectl` target this cluster by
default.

## How do I deploy my springboot app to kubernetes with minikube?

1. Create a cluster

- You can use minikube. Start a cluster with `minikube start`.

2. Create a springboot app

- We are using `kubeboot`, defined in the folder of the same name.

3. Create a docker image for running your springboot app

- We are using the docker image defined by the Dockerfile in `kubeboot/`

4. Deploy your docker image to kubernetes

- Run `./deploy`. This does the following.

1. Prepares the local environment
2. Builds the image
3. Runs it in kubernetes
4. Exposes the app locally
5. Verifies that it's okay with a curl.

## How do I see what's currently running in kubernetes?

- The command `kubectl get all` will give you lots of information about what's currently running.

## And how do I switch it off?

- Use `./kubectl-delete-kubeboot`
