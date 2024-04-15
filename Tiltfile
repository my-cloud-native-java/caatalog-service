# -*- mode: Python -*-

# Build
docker_build(
  'catalog-service',
  '.',
  live_update = [
    sync('./bin/main', '/workspace/bin/main'),
    sync('./src/main', '/workspace/src/main'),
    sync('./.gradle', '/workspace/.gradle'),
    sync('build', '/workspace/build'),
  ]
)

# deploy
k8s_yaml(['k8s/deployment.yaml', 'k8s/service.yaml'])

# manage
k8s_resource('catalog-service', port_forwards=['9001'])
