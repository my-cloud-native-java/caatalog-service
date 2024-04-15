# -*- mode: Python -*-

# Build
custom_build(
    ref = 'catalog-service',
    command = 'eval $(minikube docker-env --profile polar); ./gradlew bootBuildImage --imageName $EXPECTED_REF',
    deps = ['build.gradle', 'src']
)

# deploy
k8s_yaml(['k8s/deployment.yaml', 'k8s/service.yaml'])

# manage
k8s_resource('catalog-service', port_forwards=['9001'])
